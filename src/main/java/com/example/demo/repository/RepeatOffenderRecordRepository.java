public interface RepeatOffenderRecordRepository
        extends JpaRepository<RepeatOffenderRecord, Long> {

    List<RepeatOffenderRecord> findByStudentProfile_Id(Long studentId);

    List<RepeatOffenderRecord> findByStudentProfile(StudentProfile studentProfile);
}
