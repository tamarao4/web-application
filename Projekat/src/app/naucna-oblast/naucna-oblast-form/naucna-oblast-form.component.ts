import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NaucnaOblast } from 'src/app/model/naucna-oblast';

@Component({
  selector: 'app-naucna-oblast-form',
  templateUrl: './naucna-oblast-form.component.html',
  styleUrls: ['./naucna-oblast-form.component.css']
})
export class NaucnaOblastFormComponent implements OnInit {
  @Input()
  naucnaOblast: NaucnaOblast|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    naziv: new FormControl(null, [Validators.required]),
  });

  constructor(private router: Router) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.naucnaOblast?.id);
    this.form.get("naziv")?.setValue(this.naucnaOblast?.naziv);
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
