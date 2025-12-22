package com.example.demo;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.*;
import com.example.demo.service.impl.*;
import com.example.demo.servlet.BasicServlet;
import com.example.demo.util.RepeatOffenderCalculator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@Listeners(TestResultListener.class)
public class AcademicIntegrityApplicationTests {

    // region Mocks and services

    @Mock
    private StudentProfileRepository studentProfileRepository;
    @Mock
    private IntegrityCaseRepository integrityCaseRepository;
    @Mock
    private EvidenceRecordRepository evidenceRecordRepository;
    @Mock
    private PenaltyActionRepository penaltyActionRepository;
    @Mock
    private RepeatOffenderRecordRepository repeatOffenderRecordRepository;
    @Mock
    private AppUserRepository appUserRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private JwtTokenProvider jwtTokenProvider;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private PasswordEncoder passwordEncoder;

    private StudentProfileService studentProfileService;
    private IntegrityCaseService integrityCaseService;
    private EvidenceRecordService evidenceRecordService;
    private PenaltyActionService penaltyActionService;
    private RepeatOffenderRecordService repeatOffenderRecordService;
    private AuthServiceImpl authServiceImpl;

    private RepeatOffenderCalculator calculator;

    @BeforeClass
    public void init() {
        MockitoAnnotations.openMocks(this);
        calculator = new RepeatOffenderCalculator();

        studentProfileService = new StudentProfileServiceImpl(
                studentProfileRepository,
                integrityCaseRepository,
                repeatOffenderRecordRepository,
                calculator
        );

        integrityCaseService = new IntegrityCaseServiceImpl(
                integrityCaseRepository,
                studentProfileRepository
        );

        evidenceRecordService = new EvidenceRecordServiceImpl(
                evidenceRecordRepository,
                integrityCaseRepository
        );

        penaltyActionService = new PenaltyActionServiceImpl(
            penaltyActionRepository,
            integrityCaseRepository
        );

        repeatOffenderRecordService = new RepeatOffenderRecordServiceImpl(
                studentProfileRepository,
                integrityCaseRepository,
                repeatOffenderRecordRepository,
                calculator
        );

        authServiceImpl = new AuthServiceImpl(
                appUserRepository,
                roleRepository,
                passwordEncoder,
                authenticationManager,
                jwtTokenProvider
        );
    }

    // Helper subclass to make servlet methods public for testing
    private static class TestableServlet extends BasicServlet {
        @Override
        public void doGet(HttpServletRequest req, HttpServletResponse resp) {
            try {
                super.doGet(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void doPost(HttpServletRequest req, HttpServletResponse resp) {
            try {
                super.doPost(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Helper methods to create sample entities

    private StudentProfile sampleStudent(Long id) {
        StudentProfile s = new StudentProfile();
        s.setId(id);
        s.setStudentId("S" + id);
        s.setName("Student " + id);
        s.setEmail("student" + id + "@test.com");
        s.setProgram("CS");
        s.setYearLevel(2);
        s.setRepeatOffender(false);
        s.setCreatedAt(LocalDateTime.now());
        return s;
    }

    private IntegrityCase sampleCase(Long id, StudentProfile student) {
        IntegrityCase c = new IntegrityCase();
        c.setId(id);
        c.setStudentProfile(student);
        c.setCourseCode("CS101");
        c.setInstructorName("Dr. Smith");
        c.setDescription("Cheating on exam");
        c.setStatus("OPEN");
        c.setIncidentDate(LocalDate.now());
        c.setCreatedAt(LocalDateTime.now());
        return c;
    }

    private EvidenceRecord sampleEvidence(Long id, IntegrityCase c) {
        EvidenceRecord e = new EvidenceRecord();
        e.setId(id);
        e.setIntegrityCase(c);
        e.setEvidenceType("TEXT");
        e.setContent("Evidence details");
        e.setSubmittedBy("Faculty");
        e.setSubmittedAt(LocalDateTime.now());
        return e;
    }

    private PenaltyAction samplePenalty(Long id, IntegrityCase c) {
        PenaltyAction p = new PenaltyAction();
        p.setId(id);
        p.setIntegrityCase(c);
        p.setPenaltyType("WARNING");
        p.setDetails("First warning");
        p.setIssuedBy("Committee");
        p.setIssuedAt(LocalDateTime.now());
        return p;
    }

    // ------------------------------------------------------------------------
    // 1) Develop and deploy a simple servlet using Tomcat Server (1-8)
    // ------------------------------------------------------------------------

    @Test(groups = "servlet", priority = 1)
    public void testServletDoGetReturnsOk() throws Exception {
        TestableServlet servlet = new TestableServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        StringWriter sw = new StringWriter();
        PrintWriter writer = new PrintWriter(sw);
        when(response.getWriter()).thenReturn(writer);

        servlet.doGet(request, response);

        verify(response).setStatus(HttpServletResponse.SC_OK);
        writer.flush();
        Assert.assertTrue(sw.toString().contains("Servlet is running"));
    }

    @Test(groups = "servlet", priority = 2)
    public void testServletDoPostReturnsCreated() throws Exception {
        TestableServlet servlet = new TestableServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        StringWriter sw = new StringWriter();
        PrintWriter writer = new PrintWriter(sw);
        when(response.getWriter()).thenReturn(writer);

        servlet.doPost(request, response);

        verify(response).setStatus(HttpServletResponse.SC_CREATED);
        writer.flush();
        Assert.assertTrue(sw.toString().contains("Servlet POST handled"));
    }

    @Test(groups = "servlet", priority = 3)
    public void testServletDoGetHandlesNullRequest() throws Exception {
        TestableServlet servlet = new TestableServlet();
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(response.getWriter()).thenReturn(new PrintWriter(new StringWriter()));

        servlet.doGet(null, response);

        verify(response).setStatus(HttpServletResponse.SC_OK);
    }

    @Test(groups = "servlet", priority = 4)
    public void testServletHandlesMultipleSequentialCalls() throws Exception {
        TestableServlet servlet = new TestableServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(response.getWriter()).thenReturn(new PrintWriter(new StringWriter()));

        servlet.doGet(request, response);
        servlet.doGet(request, response);
        servlet.doPost(request, response);

        verify(response, atLeast(3)).getWriter();
    }

    @Test(groups = "servlet", priority = 5)
    public void testServletResponseWriterIsRequested() throws Exception {
        TestableServlet servlet = new TestableServlet();
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(response.getWriter()).thenReturn(new PrintWriter(new StringWriter()));

        servlet.doGet(null, response);

        verify(response).getWriter();
    }

    @Test(groups = "servlet", priority = 6)
    public void testServletGetContentNotEmpty() throws Exception {
        TestableServlet servlet = new TestableServlet();
        HttpServletResponse response = mock(HttpServletResponse.class);
        StringWriter sw = new StringWriter();
        when(response.getWriter()).thenReturn(new PrintWriter(sw));

        servlet.doGet(null, response);

        Assert.assertFalse(sw.toString().isEmpty());
    }

    @Test(groups = "servlet", priority = 7)
    public void testServletPostContentNotEmpty() throws Exception {
        TestableServlet servlet = new TestableServlet();
        HttpServletResponse response = mock(HttpServletResponse.class);
        StringWriter sw = new StringWriter();
        when(response.getWriter()).thenReturn(new PrintWriter(sw));

        servlet.doPost(null, response);

        Assert.assertFalse(sw.toString().isEmpty());
    }

    @Test(groups = "servlet", priority = 8, expectedExceptions = RuntimeException.class)
    public void testServletHandlesWriterExceptionGracefully() throws Exception {
        TestableServlet servlet = new TestableServlet();
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(response.getWriter()).thenThrow(new RuntimeException("IO error"));

        servlet.doGet(null, response);
    }

    // ------------------------------------------------------------------------
    // 2) Implement CRUD operations using Spring Boot and REST APIs (9-23)
    // ------------------------------------------------------------------------

    @Test(groups = "crud", priority = 9)
    public void testCreateStudentProfileSuccess() {
        StudentProfile s = sampleStudent(1L);
        when(studentProfileRepository.save(any(StudentProfile.class))).thenReturn(s);

        StudentProfile created = studentProfileService.createStudent(s);

        Assert.assertNotNull(created);
        Assert.assertEquals(created.getStudentId(), "S1");
        verify(studentProfileRepository).save(any(StudentProfile.class));
    }

    @Test(groups = "crud", priority = 10)
    public void testCreateStudentProfileSetsRepeatOffenderFalse() {
        StudentProfile s = sampleStudent(2L);
        s.setRepeatOffender(true);
        when(studentProfileRepository.save(any(StudentProfile.class))).thenAnswer(invocation -> {
            StudentProfile arg = invocation.getArgument(0);
            return arg;
        });

        StudentProfile created = studentProfileService.createStudent(s);

        Assert.assertFalse(created.getRepeatOffender());
    }

    @Test(groups = "crud", priority = 11)
    public void testGetStudentByIdFound() {
        StudentProfile s = sampleStudent(3L);
        when(studentProfileRepository.findById(3L)).thenReturn(Optional.of(s));

        StudentProfile result = studentProfileService.getStudentById(3L);

        Assert.assertEquals(result.getId(), Long.valueOf(3L));
    }

    @Test(groups = "crud", priority = 12, expectedExceptions = ResourceNotFoundException.class)
    public void testGetStudentByIdNotFoundThrows() {
        when(studentProfileRepository.findById(99L)).thenReturn(Optional.empty());
        studentProfileService.getStudentById(99L);
    }

    @Test(groups = "crud", priority = 13)
    public void testGetAllStudentsReturnsList() {
        when(studentProfileRepository.findAll())
                .thenReturn(Arrays.asList(sampleStudent(1L), sampleStudent(2L)));

        List<StudentProfile> students = studentProfileService.getAllStudents();

        Assert.assertEquals(students.size(), 2);
    }

    @Test(groups = "crud", priority = 14)
    public void testUpdateRepeatOffenderStatusWithTwoCasesMarksRepeat() {
        StudentProfile s = sampleStudent(4L);
        IntegrityCase c1 = sampleCase(1L, s);
        IntegrityCase c2 = sampleCase(2L, s);

        when(studentProfileRepository.findById(4L)).thenReturn(Optional.of(s));
        when(integrityCaseRepository.findByStudentProfile(s)).thenReturn(Arrays.asList(c1, c2));
        when(repeatOffenderRecordRepository.findByStudentProfile(s)).thenReturn(Optional.empty());
        when(repeatOffenderRecordRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));
        when(studentProfileRepository.save(any(StudentProfile.class))).thenAnswer(invocation -> invocation.getArgument(0));

        StudentProfile updated = studentProfileService.updateRepeatOffenderStatus(4L);

        Assert.assertTrue(updated.getRepeatOffender());
    }

    @Test(groups = "crud", priority = 15)
    public void testUpdateRepeatOffenderStatusWithNoCasesNotRepeat() {
        StudentProfile s = sampleStudent(5L);
        when(studentProfileRepository.findById(5L)).thenReturn(Optional.of(s));
        when(integrityCaseRepository.findByStudentProfile(s)).thenReturn(Collections.emptyList());
        when(repeatOffenderRecordRepository.findByStudentProfile(s)).thenReturn(Optional.empty());
        when(repeatOffenderRecordRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));
        when(studentProfileRepository.save(any(StudentProfile.class))).thenAnswer(invocation -> invocation.getArgument(0));

        StudentProfile updated = studentProfileService.updateRepeatOffenderStatus(5L);

        Assert.assertFalse(updated.getRepeatOffender());
    }

    @Test(groups = "crud", priority = 16)
    public void testCreateIntegrityCaseWithValidStudent() {
        StudentProfile s = sampleStudent(6L);
        IntegrityCase integrityCase = sampleCase(10L, s);
        integrityCase.setStudentProfile(s);

        when(studentProfileRepository.findById(6L)).thenReturn(Optional.of(s));
        when(integrityCaseRepository.save(any(IntegrityCase.class))).thenAnswer(invocation -> invocation.getArgument(0));

        IntegrityCase created = integrityCaseService.createCase(integrityCase);

        Assert.assertEquals(created.getStatus(), "OPEN");
        Assert.assertEquals(created.getStudentProfile().getId(), Long.valueOf(6L));
    }

    @Test(groups = "crud", priority = 17, expectedExceptions = IllegalArgumentException.class)
    public void testCreateIntegrityCaseMissingStudentThrows() {
        IntegrityCase integrityCase = new IntegrityCase();
        integrityCaseService.createCase(integrityCase);
    }

    @Test(groups = "crud", priority = 18)
    public void testUpdateIntegrityCaseStatusSuccess() {
        StudentProfile s = sampleStudent(7L);
        IntegrityCase c = sampleCase(20L, s);
        when(integrityCaseRepository.findById(20L)).thenReturn(Optional.of(c));
        when(integrityCaseRepository.save(any(IntegrityCase.class))).thenAnswer(invocation -> invocation.getArgument(0));

        IntegrityCase updated = integrityCaseService.updateCaseStatus(20L, "RESOLVED");

        Assert.assertEquals(updated.getStatus(), "RESOLVED");
    }

    @Test(groups = "crud", priority = 19)
    public void testGetCasesByStudentReturnsList() {
        StudentProfile s = sampleStudent(8L);
        List<IntegrityCase> list = Arrays.asList(sampleCase(1L, s), sampleCase(2L, s));
        when(integrityCaseRepository.findByStudentProfile_Id(8L)).thenReturn(list);

        List<IntegrityCase> result = integrityCaseService.getCasesByStudent(8L);

        Assert.assertEquals(result.size(), 2);
    }

    @Test(groups = "crud", priority = 20)
    public void testGetCaseByIdPresent() {
        StudentProfile s = sampleStudent(9L);
        IntegrityCase c = sampleCase(30L, s);
        when(integrityCaseRepository.findById(30L)).thenReturn(Optional.of(c));

        Optional<IntegrityCase> result = integrityCaseService.getCaseById(30L);

        Assert.assertTrue(result.isPresent());
    }

    @Test(groups = "crud", priority = 21)
    public void testGetCaseByIdAbsentReturnsEmpty() {
        when(integrityCaseRepository.findById(40L)).thenReturn(Optional.empty());

        Optional<IntegrityCase> result = integrityCaseService.getCaseById(40L);

        Assert.assertFalse(result.isPresent());
    }

    @Test(groups = "crud", priority = 22)
    public void testSubmitEvidenceSuccess() {
        StudentProfile s = sampleStudent(10L);
        IntegrityCase c = sampleCase(50L, s);
        EvidenceRecord e = sampleEvidence(1L, c);

        when(integrityCaseRepository.findById(50L)).thenReturn(Optional.of(c));
        when(evidenceRecordRepository.save(any(EvidenceRecord.class))).thenAnswer(invocation -> invocation.getArgument(0));

        EvidenceRecord saved = evidenceRecordService.submitEvidence(e);

        Assert.assertEquals(saved.getIntegrityCase().getId(), Long.valueOf(50L));
    }

    @Test(groups = "crud", priority = 23)
    public void testAddPenaltyMovesCaseToUnderReview() {
        StudentProfile s = sampleStudent(11L);
        IntegrityCase c = sampleCase
