class DarkexService
{    
    constructor() {
        this.URL = "http://localhost:8080/darkex/";
    }

    async getAlldDarkex() {
        try {            
            const response = await fetch(this.URL);
            const darkexJson = await response.json();
            console.log("Darkex: ",darkexJson);
            return darkexJson;
      
          } catch (err) {            
            console.error(err);
          }
    }

    async getDarkex(id) 
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

    async createDarkex(darkex)
     {
        return fetch(this.URL, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(darkex)
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

    async deletePerson(id)
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

    async updateDarkex(darkex) 
    {        
        return fetch(this.URL+darkex.id, {
            method: "PUT",            
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(darkex)
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
export default DarkexService;