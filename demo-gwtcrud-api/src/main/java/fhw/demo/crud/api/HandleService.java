package fhw.demo.crud.api;

import fhw.demo.crud.dto.DoctorDTO;

import java.util.List;

/**
 * @author fhw
 * @version 1.0
 * @date 2022-05-06 20:15
 */


public interface HandleService {

    List<DoctorDTO> get(String condition);

    /**
     * 添加新医生，返回新添加的医生编号
     *
     * @param doctorDTO 添加的医生信息
     * @return 医生编号
     */
    DoctorDTO add(DoctorDTO doctorDTO);

    boolean delete(DoctorDTO doctorDTO);

    DoctorDTO getById(Long id);

    List<DoctorDTO> list();
}
