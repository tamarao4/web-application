import { Mesto } from 'src/app/model/mesto';
import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Adresa } from 'src/app/model/adresa';

@Component({
  selector: 'app-adresa-form',
  templateUrl: './adresa-form.component.html',
  styleUrls: ['./adresa-form.component.css']
})
export class AdresaFormComponent implements OnInit {
  @Input()
  mesto: Mesto [] = []

  @Input()
  adrese: Adresa|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    ulica: new FormControl(null, [Validators.required]),
    broj: new FormControl(null, [Validators.required]),
    mesto: new FormControl(null),

  });

  constructor(private router: Router) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.adrese?.id);
    this.form.get("ulica")?.setValue(this.adrese?.ulica);
    this.form.get("broj")?.setValue(this.adrese?.broj);
    this.form.get("mesto")?.setValue({...this.adrese?.mesto});
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
