package com.github.pmelin.enem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entity that represents a school.
 */
@Document(collection = "schools")
public class School {

	@Id
	private String id;
	private Long code;
	private String name;
	private String uf;
	private String municipality;
	private String adminDependency;
	private Double participationRate;
	private String permanenceRate;
	private Double teacherTraining;
	private Double approvalRate;
	private Double disapprovalRate;
	private Double abandonmentRate;
	private Double average;

	public School() {

	}

	public School(Long code, String name, String uf, String municipality, String adminDependency, Double average) {
		super();
		this.code = code;
		this.name = name;
		this.uf = uf;
		this.municipality = municipality;
		this.adminDependency = adminDependency;
		this.average = average;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public String getAdminDependency() {
		return adminDependency;
	}

	public void setAdminDependency(String adminDependency) {
		this.adminDependency = adminDependency;
	}

	public Double getParticipationRate() {
		return participationRate;
	}

	public void setParticipationRate(Double participationRate) {
		this.participationRate = participationRate;
	}

	public String getPermanenceRate() {
		return permanenceRate;
	}

	public void setPermanenceRate(String permanenceRate) {
		this.permanenceRate = permanenceRate;
	}

	public Double getTeacherTraining() {
		return teacherTraining;
	}

	public void setTeacherTraining(Double teacherTraining) {
		this.teacherTraining = teacherTraining;
	}

	public Double getApprovalRate() {
		return approvalRate;
	}

	public void setApprovalRate(Double approvalRate) {
		this.approvalRate = approvalRate;
	}

	public Double getDisapprovalRate() {
		return disapprovalRate;
	}

	public void setDisapprovalRate(Double disapprovalRate) {
		this.disapprovalRate = disapprovalRate;
	}

	public Double getAbandonmentRate() {
		return abandonmentRate;
	}

	public void setAbandonmentRate(Double abandonmentRate) {
		this.abandonmentRate = abandonmentRate;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}
}
