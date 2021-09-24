import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { AppService } from './app.service';
import { Employee } from './model/employee.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'frontend';
  errorMessage!: string;
  successMessage!: string;
  isSaving = false;
  employee: Employee = new Employee();
  supervisors: string[] = [];

  employeeForm = this.fb.group({
    firstName: ['', [Validators.required, Validators.pattern('^[a-zA-Z ]*$')]],
    lastName: ['', [Validators.required, Validators.pattern('^[a-zA-Z ]*$')]],
    notifyByEmail: [],
    notifyByPhone: [],
    supervisor: ['', [Validators.required]],
    email: ['', [optionalValidator([Validators.email])]],
    phone: ['', []]
  });

  constructor(private fb: FormBuilder, private service: AppService) { }

  ngOnInit(): void {
    this.updateForm(this.employee);
    this.service.supervisors().subscribe(
      res => this.supervisors = res
    );
  }

  save(): void {
    this.updateEmployee();
    if (this.validate()) {
      this.isSaving = true;
      this.errorMessage = null;
      this.successMessage = null;
      this.service.create(this.employee).subscribe(
        () => this.onSaveSuccess(),
        (e) => this.onSaveError(e)
      );
    }

  }

  private validate() {
    if (!this.employee.firstName || !this.employee.lastName || !this.employee.supervisor) {
      return false;
    }
    if (this.employee.notifyByEmail && !this.employee.email) {
      return false;
    }
    if (this.employee.notifyByPhone && !this.employee.phone) {
      return false;
    }

    return true;
  }

  private updateForm(employee: Employee): void {
    this.employeeForm.patchValue({
      firstName: employee.firstName,
      lastName: employee.lastName,
      email: employee.email,
      phone: employee.phone,
      supervisor: employee.supervisor,
      notifyByEmail: employee.notifyByEmail,
      notifyByPhone: employee.notifyByPhone,
    });

  }
  private updateEmployee(): void {
    this.employee.firstName = this.employeeForm.value.firstName;
    this.employee.lastName = this.employeeForm.value.lastName;
    this.employee.email = this.employeeForm.value.email;
    this.employee.phone = this.employeeForm.value.phone;
    this.employee.supervisor = this.employeeForm.value.supervisor;
    this.employee.notifyByEmail = this.employeeForm.value.notifyByEmail;
    this.employee.notifyByPhone = this.employeeForm.value.notifyByPhone;
  }

  private onSaveSuccess(): void {
    console.log('hi');
    this.isSaving = false;
    this.successMessage = 'Your Notification Form submitted sucessfully';
  }

  private onSaveError(e): void {
    this.isSaving = false;
    this.errorMessage = e.error.message;
  }


}
import { ValidatorFn, AbstractControl } from '@angular/forms';

export function optionalValidator(validators?: (ValidatorFn | null | undefined)[]): ValidatorFn {
  return (control: AbstractControl): { [key: string]: any } => {

    return control.value ? Validators.compose(validators)(control) : null;
  };
}
