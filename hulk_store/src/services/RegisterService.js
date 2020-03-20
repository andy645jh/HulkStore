class RegisterService
{    
    constructor() {
        this.URL = "http://localhost:8080/registers/";
    }

    async getAlldRegister() {
        try {            
            const response = await fetch(this.URL);
            const registerJson = await response.json();
            console.log("Register: ",registerJson);
            return registerJson;
      
          } catch (err) {            
            console.error(err);
          }
    }

    async getPerson(id) 
    {        
        return fetch(this.URL+id,{
            method:'GET'
        })
            .then(response => {
                if (!response.ok) {
                    this.handleResponseError(response);
                }
                return response.json();
            })
            .catch(error => {
                this.handleError(error);
            });
    }

    async createRegister(register, darkexId)
     {
        return fetch(this.URL + darkexId, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(register)
        })
            .then(response => {
                if (!response.ok) {
                    this.handleResponseError(response);
                }                
                return response.ok;
            })
            .catch(error => {
                this.handleError(error);
            });
    }

    async deleteRegister(id)
    {        
        return fetch(this.URL+id, {
            method: "DELETE",            
        })
            .then(response => {
                if (!response.ok) {
                    this.handleResponseError(response);
                }
                return true;
            })
            .catch(error => {
                this.handleError(error);
            });
    }

    async updateRegister(register) 
    {        
        return fetch(this.URL+register.id, {
            method: "PUT",            
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(register)
        })
            .then(response => {
                if (!response.ok) {
                    this.handleResponseError(response);
                }
                return response.ok;
            })
            .catch(error => {
                this.handleError(error);
            });
    }

    handleResponseError(response) {
        throw new Error("HTTP error, status = " + response.status);
    }

    handleError(error) {
        console.log(error.message);
    }
}
export default RegisterService;