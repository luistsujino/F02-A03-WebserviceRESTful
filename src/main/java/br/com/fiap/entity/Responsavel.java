package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_RESPONSAVEL")
@SequenceGenerator(name="responsavel", sequenceName ="SQ_TB_RESPONSAVEL", allocationSize = 1)
public class Responsavel {
	
	@Id
	@Column(name="cd_responsavel")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "responsavel") 
	private Integer codigo;
	
	@Lob
	@Column(name="fl_foto")
	private byte[] foto;
	
	@Column(name="nm_responsavel", length=60, nullable=false)
	private String nome;
	
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	
	@Column(name="nm_cargo", length=30)
	private String cargo;
	
	@Column(name="nr_subordinados", length=10)
	private Integer subordinados;
	
	@Column(name="qd_equipamentos", length=10)
	private Integer equipamentos;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo_setor", length=40, nullable=false)
	private TipoSetor setor;
	
	
	//Construtores
	public Responsavel() {}

	public Responsavel(String nome, Calendar dataNascimento, String cargo,
			Integer subordinados, Integer equipamentos, TipoSetor setor) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cargo = cargo;
		this.subordinados = subordinados;
		this.equipamentos = equipamentos;
		this.setor = setor;
	}
	
	public Responsavel(Integer codigo, byte[] foto, String nome, Calendar dataNascimento, String cargo,
			Integer subordinados, Integer equipamentos, TipoSetor setor) {
		super();
		this.codigo = codigo;
		this.foto = foto;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cargo = cargo;
		this.subordinados = subordinados;
		this.equipamentos = equipamentos;
		this.setor = setor;
	}

	@PrePersist 
	public void executar() {
		System.out.println("Cadastrando um responsavel...");
	}
		
	@PostLoad 
	public void carregar() {
		System.out.println("Carregando um responsavel...");
	}
	
	
	//Getters and Setters
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Integer getSubordinados() {
		return subordinados;
	}

	public void setSubordinados(Integer subordinados) {
		this.subordinados = subordinados;
	}

	public Integer getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(Integer equipamentos) {
		this.equipamentos = equipamentos;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public TipoSetor getSetor() {
		return setor;
	}

	public void setSetor(TipoSetor setor) {
		this.setor = setor;
	}
	
}
