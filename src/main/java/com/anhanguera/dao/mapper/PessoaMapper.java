package com.anhanguera.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.anhanguera.entity.PessoaEntity;

public class PessoaMapper implements RowMapper<PessoaEntity>{

	@Override
	public PessoaEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		PessoaEntity p = new PessoaEntity();
		
		p.setIdPessoa(rs.getInt("idPessoa"));
		p.setNome(rs.getString("nome"));
		p.setIdade(rs.getInt("idade"));
		
		return p;
	}

}
