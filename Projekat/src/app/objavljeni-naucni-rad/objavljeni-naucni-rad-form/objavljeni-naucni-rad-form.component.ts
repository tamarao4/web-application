import { ObjavljeniNaucniRad } from './../../model/objavljeni-naucni-rad';
import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { NaucniRad } from 'src/app/model/naucni-rad';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-objavljeni-naucni-rad-form',
  templateUrl: './objavljeni-naucni-rad-form.component.html',
  styleUrls: ['./objavljeni-naucni-rad-form.component.css']
})
export class ObjavljeniNaucniRadFormComponent implements OnInit {
  
  @Input()
  naucniRad: NaucniRad [] = []
  @Input()
  objavljeniNaucniRad: ObjavljeniNaucniRad|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    datumObjave: new FormControl(null, [Validators.required]),
    naucniRad: new FormControl(null)
  });

  constructor(private router: Router) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.objavljeniNaucniRad?.id);
    this.form.get("datumObjave")?.setValue(this.objavljeniNaucniRad?.datumObjave);
    this.form.get("naucniRad")?.setValue(this.objavljeniNaucniRad?.naucniRad);
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
