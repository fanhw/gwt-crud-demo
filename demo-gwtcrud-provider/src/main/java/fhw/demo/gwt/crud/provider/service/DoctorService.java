package fhw.demo.gwt.crud.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import fhw.demo.gwt.crud.provider.model.Doctor;
import sun.rmi.runtime.Log;

import java.util.List;

/**
 * @author fhw
 * @version 1.0
 * @date 2022-05-06 19:59
 */


public interface DoctorService extends IService<Doctor> {
    /**
     * 方法
     *
     * @param
     * @return
     */
    List<Doctor> findAll();

    /**
     * 方法
     *
     * @param doctor
     * @return
     */
    void add(Doctor doctor);

    /**
     * 方法
     *
     * @param doctor
     * @return
     */
    int modify(Doctor doctor);

    /**
     * 方法
     *
     * @param id
     * @return
     */
    Doctor findById(Long id);

    /**
     * 方法
     *
     * @param id
     * @return
     */
    boolean delete(Long id);

    /**
     * 方法
     *
     * @param condition
     * @return
     */
    List<Doctor> findByCondition(String condition);
}
