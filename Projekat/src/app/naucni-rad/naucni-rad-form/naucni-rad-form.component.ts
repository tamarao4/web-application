import { NaucniRad } from './../../model/naucni-rad';
import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-naucni-rad-form',
  templateUrl: './naucni-rad-form.component.html',
  styleUrls: ['./naucni-rad-form.component.css']
})
export class NaucniRadFormComponent implements OnInit {
  @Input()
  naucniRad: NaucniRad|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    naziv: new FormControl(null, [Validators.required])
  });

  constructor(private router: Router) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.naucniRad?.id);
    this.form.get("naziv")?.setValue(this.naucniRad?.naziv);
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
