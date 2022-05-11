package fhw.demo.crud.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fhw
 * @version 1.0
 * @date 2022-05-06 20:15
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
    @JsonFormat(pattern = "yyyy-MM-dd",timezone ="Asia/Shanghai")
    private Date birth;


    private String birthStr;
    /**
     * 工号
     */
    private String jobNumber;

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getBirthStr() {
        return birthStr;
    }

    public void setBirthStr(String birthStr) {
        this.birthStr = birthStr;
    }

    public DoctorDTO() {
    }

    public DoctorDTO(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public DoctorDTO(Long id, String name, Integer age, Date birth, String jobNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birth = birth;
        this.jobNumber = jobNumber;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
