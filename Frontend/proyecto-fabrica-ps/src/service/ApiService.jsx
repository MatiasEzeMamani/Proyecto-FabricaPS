import axios from "axios";

export default class ApiService {
  static BASE_URL = "http://localhost:4040";

  static getHeader() {
    const token = localStorage.getItem("token");
    return token
      ? { Authorization: `Bearer ${token}`, "Content-Type": "application/json" }
      : { "Content-Type": "application/json" };
  }

  /** Auth */

  /*This register a new worker */
  static async registerWorker(registration) {
    const response = await axios.post(
      `${this.BASE_URL}/api/workers/register`,
      registration
    );

    return response.data;
  }

  /* This login a registered worker */
  static async loginWorker(loginDetails) {
    const response = await axios.post(
      `${this.BASE_URL}/api/workers/login`,
      loginDetails
    );
    return response.data;
  }

  /** Users */

  /* This is to get the worker profile*/
  static async getAllWorkers() {
    const response = await axios.get(`${this.BASE_URL}/api/workers`, {
      headers: this.getHeader(),
    });
    return response.data;
  }

  static async getWorkerProfile() {
    const response = await axios.get(`${this.BASE_URL}/api/workers/info`, {
      headers: this.getHeader(),
    });
    return response.data;
  }

  /* This is the to get a single worker */
  static async getWorkerById(workerId) {
    const response = await axios.get(
      `${this.BASE_URL}/api/workers/${workerId}`,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  static async getWorkerByEmail(workerEmail) {
    const response = await axios.get(
      `${this.BASE_URL}/api/workers/me/${workerEmail}`,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  static async updateWorker(workerId, workerData) {
    const response = await axios.put(
      `${this.BASE_URL}/api/workers/edit/${workerId}`,
      workerData,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  static async deleteWorker(workerId) {
    const response = await axios.delete(
      `${this.BASE_URL}/api/workers/${workerId}`,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  /** Part */
  /* This adds a new part to the database */
  static async addPart(formData) {
    const result = await axios.post(
      `${this.BASE_URL}/api/parts/add`,
      formData,
      {
        headers: {
          ...this.getHeader(),
          "Content-Type": "multipart/form-data",
        },
      }
    );
    return result.data;
  }

  /* This gets all parts */
  static async getAllParts() {
    const response = await axios.get(`${this.BASE_URL}/api/parts/`, {
      headers: this.getHeader(),
    });
    return response.data;
  }

  static async getPartById(partId) {
    const response = await axios.get(`${this.BASE_URL}/api/parts/${partId}`, {
      headers: this.getHeader(),
    });
    return response.data;
  }

  static async createPart(partData) {
    const response = await axios.post(
      `${this.BASE_URL}/api/parts/add`,
      partData,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  static async updatePart(partId, partData) {
    const response = await axios.put(
      `${this.BASE_URL}/api/parts/edit/${partId}`,
      partData,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  static async deletePart(partId) {
    const response = await axios.delete(
      `${this.BASE_URL}/api/parts/${partId}`,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  /* Material */

  static async getAllMaterials() {
    const response = await axios.get(`${this.BASE_URL}/api/materials/`, {
      headers: this.getHeader(),
    });
    return response.data;
  }

  static async getMaterialById(materialId) {
    const response = await axios.get(
      `${this.BASE_URL}/api/materials/${materialId}`,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  static async updateMaterial(materialId, materialData) {
    const response = await axios.put(
      `${this.BASE_URL}/api/materials/edit/${materialId}`,
      materialData,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  static async deleteMaterial(materialId) {
    const response = await axios.delete(
      `${this.BASE_URL}/api/materials/${materialId}`,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  static async createMaterial(materialData) {
    const response = await axios.post(
      `${this.BASE_URL}/api/materials/add`,
      materialData,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  /** Article */

  static async getAllArticles() {
    const response = await axios.get(`${this.BASE_URL}/api/articles/`, {
      headers: this.getHeader(),
    });
    return response.data;
  }

  static async getArticleById(articleId) {
    const response = await axios.get(
      `${this.BASE_URL}/api/articles/${articleId}`,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  static async updateArticle(articleId, articleData) {
    const response = await axios.put(
      `${this.BASE_URL}/api/articles/${articleId}`,
      articleData,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  static async deleteArticle(articleId) {
    const response = await axios.delete(
      `${this.BASE_URL}/api/articles/${articleId}`,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  static async createArticle(articleData) {
    const response = await axios.post(
      `${this.BASE_URL}/api/articles/add`,
      articleData,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  /** Component */

  static async getAllComponents() {
    const response = await axios.get(`${this.BASE_URL}/api/components`, {
      headers: this.getHeader(),
    });
    return response.data;
  }

  static async getComponentById(componentId) {
    const response = await axios.get(
      `${this.BASE_URL}/api/components/${componentId}`,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  static async updateComponent(componentId, componentData) {
    const response = await axios.put(
      `${this.BASE_URL}/api/components/edit/${componentId}`,
      componentData,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  static async deleteComponent(componentId) {
    const response = await axios.delete(
      `${this.BASE_URL}/api/components/${componentId}`,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  static async createComponent(componentData) {
    const response = await axios.post(
      `${this.BASE_URL}/api/components/add`,
      componentData,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  /** ComponentPart */

  static async getAllComponentPart() {
    const response = await axios.get(`${this.BASE_URL}/api/component-part`, {
      headers: this.getHeader(),
    });
    return response.data;
  }

  static async getComponentPartByPart(componentPartId) {
    const response = await axios.get(
      `${this.BASE_URL}/api/component-part/part/${componentPartId}`,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  static async getComponentPartByComponent(componentPartId) {
    const response = await axios.get(
      `${this.BASE_URL}/api/component-part/component/${componentPartId}`,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  static async deleteComponentPart(componentPartId) {
    const response = await axios.delete(
      `${this.BASE_URL}/api/component-part/${componentPartId}`,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  static async createComponentPart(componentId, partId, quantity) {
    const response = await axios.post(
      `${this.BASE_URL}/api/component-part/add`,
      { componentId, partId, quantity }, // Datos en el cuerpo de la solicitud
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  /** MovementDetail */

  static async getAllMovementDetail() {
    const response = await axios.get(`${this.BASE_URL}/api/movement-details`, {
      headers: this.getHeader(),
    });
    return response.data;
  }

  static async getMovementDetailById(movementDetailId) {
    const response = await axios.get(
      `${this.BASE_URL}/api/movement-details/${movementDetailId}`,
      {
        headers: this.getHeader(),
      }
    );
    return response.data;
  }

  static async createMovementDetail() {
    const response = await axios.post(`${this.BASE_URL}/api/movement-details`, {
      headers: this.getHeader(),
    });
    return response.data;
  }

  /**AUTHENTICATION CHECKER */
  static logout() {
    localStorage.removeItem("token");
    localStorage.removeItem("role");
  }

  static isAuthenticated() {
    const token = localStorage.getItem("token");
    return !!token;
  }

  static isAdmin() {
    const role = localStorage.getItem("role");
    return role === "ADMIN";
  }

  static isOperator() {
    const role = localStorage.getItem("role");
    return role === "OPERATOR";
  }
}
