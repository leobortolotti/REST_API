package com.anhanguera.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.anhanguera.dao.mapper.PessoaMapper;
import com.anhanguera.entity.PessoaEntity;

@Repository
public class PessoaDao extends BaseDao{

	private String tableName = "Pessoa";
	private String primaryKey = "idPessoa";
	private ArrayList<String> columns = new ArrayList<String>();
	
	public PessoaDao(){
		columns.add("nome");
		columns.add("idade");
	}
	
	public List<PessoaEntity> list(int id){
		List<PessoaEntity> result = new  ArrayList<PessoaEntity>();
		String sql = "SELECT * FROM " + tableName + " ";
		
		if (id == 0){
			result = jdbcTemplate.query(sql, new PessoaMapper());
		}else{
			sql += " WHERE " + primaryKey + "=?";
			result = jdbcTemplate.query(sql, new PessoaMapper(), id);
		}
		
		return result;
	}
	
	public PessoaEntity insert(PessoaEntity p){
		
		SimpleJdbcInsert i = new SimpleJdbcInsert(jdbcTemplate);
		i.setTableName(tableName);
		i.setColumnNames(columns);
		i.setGeneratedKeyName(primaryKey);
		
		Number key = i.executeAndReturnKey(new BeanPropertySqlParameterSource(p));
		
		p.setIdPessoa(key.intValue());
				
		return p;
	}
	
	public boolean update(PessoaEntity p){
		String sql = "UPDATE " + tableName + " set nome = ?, idade = ?  WHERE idPessoa = ?";
		
		//qtdLineUpdate -> quantidade de linhas atualizadas no banco, deve ser maior que 1 se atualizou
		int qtdLineUpdated = jdbcTemplate.update(sql, p.getNome(), p.getIdade(), p.getIdPessoa());
		
		if (qtdLineUpdated > 0)
			return true;
		
		return false;
	}
}
