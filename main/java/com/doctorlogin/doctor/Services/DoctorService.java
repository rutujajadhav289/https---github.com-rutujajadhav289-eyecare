package com.doctorlogin.doctor.Services;

import java.util.List;

import com.doctorlogin.doctor.Entity.Doctor;

public interface DoctorService {
	Doctor saveDoctor(Doctor doctor);
	Doctor updateDoctor(Doctor doctor, Integer id);
	List<Doctor> getAllDoctors();
	void deleteEmployee(Integer id);
}
