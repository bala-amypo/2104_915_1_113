package com.example.demo.entity;

public class RepeatOffenderRecord {

    private boolean repeatOffender;
    private int caseCount;

    public RepeatOffenderRecord(boolean repeatOffender, int caseCount) {
        this.repeatOffender = repeatOffender;
        this.caseCount = caseCount;
    }

    public boolean isRepeatOffender() {
        return repeatOffender;
    }

    public void setRepeatOffender(boolean repeatOffender) {
        this.repeatOffender = repeatOffender;
    }

    public int getCaseCount() {
        return caseCount;
    }

    public void setCaseCount(int caseCount) {
        this.caseCount = caseCount;
    }
}
