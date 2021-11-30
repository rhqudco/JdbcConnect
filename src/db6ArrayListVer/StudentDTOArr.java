package db6ArrayListVer;

public class StudentDTOArr {
    private String stdNo;
    private String stdName;
    private int stdYear;
    private String stdAddress;
    private String stdBirthday;
    private String dptNo;

    public StudentDTOArr(String stdNo,
                         String stdName,
                         int stdYear,
                         String stdAddress,
                         String stdBirthday,
                         String dptNo) {
        this.stdNo = stdNo;
        this.stdName = stdName;
        this.stdYear = stdYear;
        this.stdAddress = stdAddress;
        this.stdBirthday = stdBirthday;
        this.dptNo = dptNo;
    }
    // getter / setter : setter는 값을 저장할 때 사용, getter는 값을 반환할 때 사용
    public String getStdNo() {
        return stdNo;
    }

    public void setStdNo(String stdNo) {
        this.stdNo = stdNo;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public int getStdYear() {
        return stdYear;
    }

    public void setStdYear(int stdYear) {
        this.stdYear = stdYear;
    }

    public String getStdAddress() {
        return stdAddress;
    }

    public void setStdAddress(String stdAddress) {
        this.stdAddress = stdAddress;
    }

    public String getStdBirthday() {
        return stdBirthday;
    }

    public void setStdBirthday(String stdBirthday) {
        this.stdBirthday = stdBirthday;
    }

    public String getDptNo() {
        return dptNo;
    }

    public void setDptNo(String dptNo) {
        this.dptNo = dptNo;
    }

    @Override
    public String toString() {
        // 한꺼번에 전달하기 위해 StringBuilder 사용
        // 기존 문자열에 더하는 방식
        StringBuilder sb = new StringBuilder();
        sb.append(stdNo);
        sb.append("     ");
        sb.append(stdName);
        sb.append("     ");
        sb.append(stdYear);
        sb.append("     ");
        sb.append(stdAddress);
        sb.append("     ");
        sb.append(stdBirthday);
        sb.append("     ");
        sb.append(dptNo);

        return sb.toString();
    }
}
