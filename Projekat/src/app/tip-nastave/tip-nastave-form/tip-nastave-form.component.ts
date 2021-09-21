import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NastavnikNaRealizaciji } from 'src/app/model/nastavnik-na-realizaciji';
import { TipNastave } from 'src/app/model/tip-nastave';
import { TipNastaveService } from 'src/app/services/tip-nastave.service';

@Component({
  selector: 'app-tip-nastave-form',
  templateUrl: './tip-nastave-form.component.html',
  styleUrls: ['./tip-nastave-form.component.css']
})
export class TipNastaveFormComponent implements OnInit {
  @Input()
  nastavnikNaRealizaciji: NastavnikNaRealizaciji [] = []


  @Input()
  tipoviNastave: TipNastave|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    naziv: new FormControl(null, [Validators.required]),
    nastavnikNaRealizaciji: new FormControl(null)
  });

  constructor( 
    private router: Router, public tipNastaveService: TipNastaveService) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.tipoviNastave?.id);
    this.form.get("naziv")?.setValue(this.tipoviNastave?.naziv);
    this.form.get("nastavnikNaRealizaciji")?.setValue(this.tipoviNastave?.nastavnikNaRealizaciji);
    console.log(this.tipoviNastave)
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
