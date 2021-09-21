import { NaucniRad } from './../../model/naucni-rad';
import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { Apstrakt } from 'src/app/model/apstrakt';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-apstrakt-form',
  templateUrl: './apstrakt-form.component.html',
  styleUrls: ['./apstrakt-form.component.css']
})
export class ApstraktFormComponent implements OnInit {  
  @Input()
  naucniRad: NaucniRad [] = []

  @Input()
  apstrakt: Apstrakt|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    tekst: new FormControl(null, [Validators.required]),
    naucniRad: new FormControl(null)
  });

  constructor(private router: Router) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.apstrakt?.id);
    this.form.get("tekst")?.setValue(this.apstrakt?.tekst);
    this.form.get("naucniRad")?.setValue(this.apstrakt?.naucniRad);
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
