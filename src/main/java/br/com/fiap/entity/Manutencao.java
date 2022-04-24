package br.com.fiap.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
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
@Table(name="TB_MANUTENCAO")
@SequenceGenerator(name="manutencao", sequenceName = "SQ_TB_MANUTENCAO", allocationSize = 1)
public class Manutencao {
	
	@Id
	@Column(name="cd_manutencao")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manutencao")
	private Integer codigo;
	
	@Column(name="nm_empresa", length= 50, nullable = false, unique = true)	
	private String nome;
	
	@Column(name="dt_inicio_contrato", nullable = false)
	private Calendar dataInicioContrato;
	
	@Column(name="dt_termino_contrato", nullable = true)
	private Calendar dataTerminoContrato;
	
	@Column(name="ds_contrato", nullable = false, length = 40)
	private String contrato;
	
	@Column(name="st_ativo")
	private Boolean ativo;
	
	@Column(name="dt_cadastro", updatable = false)	
	private LocalDate dataCadastro;
	
	@Column(name="vl_contrato", precision = 11, scale = 2)
	private BigDecimal valorContrato;
	
	@Lob	
	@Column(name="ft_empresa")
	private byte[] fotoEmpresa;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_setor")
	private TipoSetor setor;

	
	//Construtores
	public Manutencao() {}
	
	public Manutencao(String nome, Calendar dataInicioContrato, Calendar dataTerminoContrato,
			String contrato, Boolean ativo, LocalDate dataCadastro, BigDecimal valorContrato, byte[] fotoEmpresa,
			TipoSetor setor) {
		this.nome = nome;
		this.dataInicioContrato = dataInicioContrato;
		this.dataTerminoContrato = dataTerminoContrato;
		this.contrato = contrato;
		this.ativo = ativo;
		this.dataCadastro = dataCadastro;
		this.valorContrato = valorContrato;
		this.fotoEmpresa = fotoEmpresa;
		this.setor = setor;
	}
	
	public Manutencao(Integer codigo, String nome, Calendar dataInicioContrato, Calendar dataTerminoContrato,
			String contrato, Boolean ativo, LocalDate dataCadastro, BigDecimal valorContrato, byte[] fotoEmpresa,
			TipoSetor setor) {
		this(nome, dataInicioContrato, dataTerminoContrato, contrato, ativo, dataCadastro,
				valorContrato, fotoEmpresa, setor);
		this.codigo = codigo;
	}
	
	@PrePersist 
	public void executar() {
		System.out.println("Cadastrando um servidor de manunteção...");
	}
			
	@PostLoad 
	public void carregar() {
		System.out.println("Carregando um servidor de manunteção...");
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

	public Calendar getDataInicioContrato() {
		return dataInicioContrato;
	}

	public void setDataInicioContrato(Calendar dataInicioContrato) {
		this.dataInicioContrato = dataInicioContrato;
	}

	public Calendar getDataTerminoContrato() {
		return dataTerminoContrato;
	}

	public void setDataTerminoContrato(Calendar dataTerminoContrato) {
		this.dataTerminoContrato = dataTerminoContrato;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public BigDecimal getValorContrato() {
		return valorContrato;
	}

	public void setValorContrato(BigDecimal valorContrato) {
		this.valorContrato = valorContrato;
	}

	public byte[] getFotoEmpresa() {
		return fotoEmpresa;
	}

	public void setFotoEmpresa(byte[] fotoEmpresa) {
		this.fotoEmpresa = fotoEmpresa;
	}

	public TipoSetor getSetor() {
		return setor;
	}

	public void setSetor(TipoSetor setor) {
		this.setor = setor;
	}	
	
}
