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
	private double participationRate;
	private String permanenceRate;
	private double teacherTraining;
	private double approvalRate;
	private double disapprovalRate;
	private double abandonmentRate;
	private double average;

	public School() {

	}

	public School(Long code, String name, String uf, String municipality, String adminDependency, double average) {
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

	public double getParticipationRate() {
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

	public double getTeacherTraining() {
		return teacherTraining;
	}

	public void setTeacherTraining(Double teacherTraining) {
		this.teacherTraining = teacherTraining;
	}

	public double getApprovalRate() {
		return approvalRate;
	}

	public void setApprovalRate(Double approvalRate) {
		this.approvalRate = approvalRate;
	}

	public double getDisapprovalRate() {
		return disapprovalRate;
	}

	public void setDisapprovalRate(Double disapprovalRate) {
		this.disapprovalRate = disapprovalRate;
	}

	public double getAbandonmentRate() {
		return abandonmentRate;
	}

	public void setAbandonmentRate(Double abandonmentRate) {
		this.abandonmentRate = abandonmentRate;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}
}
