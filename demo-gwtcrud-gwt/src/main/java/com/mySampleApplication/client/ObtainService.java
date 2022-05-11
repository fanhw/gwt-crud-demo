package com.mySampleApplication.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;


/**
 * @author fhw
 * @version 1.0
 * @date 2022-05-07 10:29
 */

@RemoteServiceRelativePath("ObtainService")
public interface ObtainService extends RemoteService {
        List<DoctorDTO> getDoctorListByIdOrName(String id);
        /**
         * 添加新医生，返回新添加的医生编号
         *
         * @param doctorDTO 添加的医生信息
         * @return 医生编号
         */
        DoctorDTO add(DoctorDTO doctorDTO);

        boolean delete(DoctorDTO person);

        List<DoctorDTO> list();
}
