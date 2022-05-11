package fhw.demo.gwt.crud.provider.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author fhw
 * @version 1.0
 * @date 2022-05-06 19:59
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_doctor")
@Entity
@Table(name = "t_doctor")
public class Doctor implements Serializable {

    @Column(name = "id", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(type=IdType.AUTO)
    private Long id;
    @TableField
    @Column(name = "name")
    private String name;
    @TableField
    @Column(name = "age")
    private Integer age;
    @Column(name = "birth")
    @Temporal(TemporalType.DATE)
    private Date birth;
    @Column(name = "job_number")
    @TableField
    private String jobNumber;
}
