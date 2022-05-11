package com.mySampleApplication.client;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fhw
 * @version 1.0
 * @date 2022-05-07 11:31
 */


public class DoctorDTO implements Serializable {
    private static final long serialVersionUID = -7757554030986166437L;
    private Long id;
    /**
     * 医生姓名
     */
    private String name;
    /**
     * 医生年纪
     */
    private Integer age;

    /**
     * 出生年月日
     */
    private Date birthday;

    private String birthStr;

    private String  jobNumber;

    public String getBirthStr() {
        return birthStr;
    }

    public void setBirthStr(String birthStr) {
        this.birthStr = birthStr;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public DoctorDTO(Long id, String name, Integer age, Date birthday,String jobNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.jobNumber = jobNumber;
    }

    public DoctorDTO() {
    }

    public DoctorDTO(Long id, String name, Integer age, Date birthday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public DoctorDTO(Long id, String name, Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DoctorDTO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", birthday=").append(birthday);
        sb.append('}');
        return sb.toString();
    }
}
