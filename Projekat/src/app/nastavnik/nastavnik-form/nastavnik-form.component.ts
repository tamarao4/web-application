import { ObjavljeniNaucniRad } from './../../model/objavljeni-naucni-rad';
import { Adresa } from 'src/app/model/adresa';
import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { Nastavnik } from 'src/app/model/nastavnik';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nastavnik-form',
  templateUrl: './nastavnik-form.component.html',
  styleUrls: ['./nastavnik-form.component.css']
})
export class NastavnikFormComponent implements OnInit {

  @Input()
  adresa: Adresa [] = []
 
  // autor 

  @Input()
  objavljeniNaucniRad: ObjavljeniNaucniRad [] = []

  @Input()
  nastavnik: Nastavnik|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    ime: new FormControl(null, [Validators.required]),
    biografija: new FormControl(null, [Validators.required]),
    jmbg: new FormControl(null, [Validators.required]),
    adresa: new FormControl(null),
    objavljeniNaucniRad: new FormControl(null)
  });

  constructor(private router: Router) { }
  
  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.nastavnik?.id);
    this.form.get("ime")?.setValue(this.nastavnik?.ime);
    this.form.get("biografija")?.setValue(this.nastavnik?.biografija);
    this.form.get("jmbg")?.setValue(this.nastavnik?.jmbg);
    this.form.get("adresa")?.setValue({...this.nastavnik?.adresa});
    this.form.get("objavljeniNaucniRad")?.setValue({...this.nastavnik?.objavljeniNaucniRad});
  }

  ngOnInit(): void {
  }

  create() {
    if(this.form.valid) {
      this.createEvent.emit(this.form.value);
      console.log(this.form.value)
    } else {
      console.log("Forma nije validna")
    }
  }

}
