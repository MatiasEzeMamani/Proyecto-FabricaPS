package com.proyecto.fabrica.ps.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "movements_worker")
public class MovementWorker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long movementWorkerId;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "worker_id")
	private Worker worker;
	
	@OneToMany(mappedBy = "movementWorkerDetail", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<MovementDetail> movementDetailWorker;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	public MovementWorker() {}
	
	public Long getMovementWorkerId() {
		return movementWorkerId;
	}

	public void setMovementWorkerId(Long movementWorkerId) {
		this.movementWorkerId = movementWorkerId;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public List<MovementDetail> getMovementDetailWorker() {
		return movementDetailWorker;
	}

	public void setMovementDetailWorker(List<MovementDetail> movementDetailWorker) {
		this.movementDetailWorker = movementDetailWorker;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date(); 
	}

	@PreUpdate 
	protected void onUpdate() {
		this.updatedAt = new Date(); 
	}
}
