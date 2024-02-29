package com.icorrea.servidorpublicobd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icorrea.servidorpublicobd.entity.ServidorPublico;

@Repository
public interface IServidorPublicoRepository extends CrudRepository<ServidorPublico, Long> {

}
