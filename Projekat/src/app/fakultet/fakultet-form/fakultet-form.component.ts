import { Nastavnik } from 'src/app/model/nastavnik';
import { Adresa } from 'src/app/model/adresa';
import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Fakultet } from 'src/app/model/fakultet';
import { Univerzitet } from 'src/app/model/univerzitet';
import { FakultetService } from 'src/app/services/fakultet.service';

@Component({
  selector: 'app-fakultet-form',
  templateUrl: './fakultet-form.component.html',
  styleUrls: ['./fakultet-form.component.css']
})
export class FakultetFormComponent implements OnInit {
  @Input()
  adresa: Adresa [] = []
  @Input()
  nastavnik: Nastavnik [] = []
  @Input()
  univerzitet: Univerzitet [] = []

  @Input()
  fakultet: Fakultet|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    naziv: new FormControl(null, [Validators.required]),
    telefon: new FormControl(null, [Validators.required]),
    email: new FormControl(null, [Validators.required]),
    opis: new FormControl(null, [Validators.required]),
    adresa: new FormControl(null),
    nastavnik: new FormControl(null),
    univerzitet: new FormControl(null)
  });

  constructor(private fakultetService: FakultetService, private router: Router) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.fakultet?.id);
    this.form.get("naziv")?.setValue(this.fakultet?.naziv);
    this.form.get("telefon")?.setValue(this.fakultet?.telefon);
    this.form.get("email")?.setValue(this.fakultet?.email);
    this.form.get("opis")?.setValue(this.fakultet?.opis);
    this.form.get("adresa")?.setValue({...this.fakultet?.adresa});
    this.form.get("nastavnik")?.setValue({...this.fakultet?.nastavnik});
    this.form.get("univerzitet")?.setValue({...this.fakultet?.univerzitet});
    
    
  }

  ngOnInit(): void {
    
   }

  create() {
    if(this.form.valid) {
      console.log(this.form.value)
      this.createEvent.emit(this.form.value); 
      
    } else {
      console.log("Forma nije validna")
    }
  }
}
