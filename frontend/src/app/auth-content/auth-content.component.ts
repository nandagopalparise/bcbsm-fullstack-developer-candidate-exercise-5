import { Component } from '@angular/core';
import { AxiosService } from '../axios.service';

@Component({
  selector: 'app-auth-content',
  templateUrl: './auth-content.component.html',
  styleUrls: ['./auth-content.component.css']
})
export class AuthContentComponent {
  data: any[] = [];
  filteredData: any[] = [];
  selectedFile: File | null = null;
  toEmail:String = '';
  emailStatus:String = ''
  searchText:String = ''

  constructor(private axiosService: AxiosService) {}

  onFileSelect(event: any) {
    this.selectedFile = event.target.files[0];
    console.log(this.selectedFile?.name);
  }

  search(event: any) {
    this.searchText = event.target.value;
    this.filteredData = this.data.filter(item =>
      item.fileName.toLowerCase().includes(this.searchText.toLowerCase())
    );
  }

  onEmailSelect(event: any){
    console.log(event.target.value);
    this.toEmail = event.target.value;
  }

  sendEmail(){
    console.log(this.selectedFile);
    console.log(this.toEmail);
    if(this.selectedFile!==null && this.toEmail !==''){

      const data = {
        toEmail:this.toEmail,
        fileName:this.selectedFile.name,
        fromEmail:localStorage.getItem("from")
      }
      this.axiosService
        .request('POST', '/saveEmail', data)
        .then((response) => {
          this.data = response.data;
          this.emailStatus = 'Successfull!!!';
        })
        .catch((error) => {
          if (error.response.status === 401) {
            this.axiosService.setAuthToken(null);
          } else {
            this.data = [error.response.code]; // Wrap the error code in an array
          }
        });
      
    } else {
      this.emailStatus = 'Email Send Failed';
    }
    
  }

  ngOnInit(): void {
    this.axiosService
      .request('GET', '/emails', {})
      .then((response) => {
        this.data = response.data;
        console.log(this.data);
        this.filteredData = this.data;
      })
      .catch((error) => {
        if (error.response.status === 401) {
          this.axiosService.setAuthToken(null);
        } else {
          this.data = [error.response.code]; // Wrap the error code in an array
        }
      });
  }
}
