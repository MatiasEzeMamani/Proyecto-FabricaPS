package com.proyecto.fabrica.ps.service.interfac;

import com.proyecto.fabrica.ps.dto.LoginRequest;
import com.proyecto.fabrica.ps.dto.Response;
import com.proyecto.fabrica.ps.dto.WorkerDTO;
import com.proyecto.fabrica.ps.models.Worker;

public interface IWorkerService {

	Response register(Worker worker);
	
	Response login(LoginRequest loginRequest);
	
	Response getAllUsers();
	
	Response deleteUser(String workerId, Worker currentUser);
	
	Response getUserById(String workerId);
	
	Response getMyInfo(String email);

	Response updateWorker(String workerId, WorkerDTO workerDTO);
}
