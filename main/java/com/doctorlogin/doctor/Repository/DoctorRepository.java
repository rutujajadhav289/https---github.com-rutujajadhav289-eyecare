package com.doctorlogin.doctor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doctorlogin.doctor.Entity.Doctor;


@Repository("doctorRepository")
public interface DoctorRepository extends CrudRepository<Doctor, Integer>, JpaRepository<Doctor, Integer>{

}
