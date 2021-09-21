import { Drzava } from 'src/app/model/drzava';
import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Mesto } from 'src/app/model/mesto';

@Component({
  selector: 'app-mesto-form',
  templateUrl: './mesto-form.component.html',
  styleUrls: ['./mesto-form.component.css']
})
export class MestoFormComponent implements OnInit {
  
  @Input()
  drzava: Drzava [] = []
  @Input()
  mesto: Mesto|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    naziv: new FormControl(null, [Validators.required]),
    drzava: new FormControl(null, [Validators.required])
  });

  constructor(private router: Router) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.mesto?.id);
    this.form.get("naziv")?.setValue(this.mesto?.naziv);
    this.form.get("drzava")?.setValue(this.mesto?.drzava);
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
