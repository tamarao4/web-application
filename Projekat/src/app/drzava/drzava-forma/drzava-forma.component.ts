import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Drzava } from 'src/app/model/drzava';

@Component({
  selector: 'app-drzava-forma',
  templateUrl: './drzava-forma.component.html',
  styleUrls: ['./drzava-forma.component.css']
})
export class DrzavaFormaComponent implements OnInit {

  @Input()


  @Input()
  drzava: Drzava|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    naziv: new FormControl(null, [Validators.required]),
    
  });

  constructor(private router: Router) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.drzava?.id);
    this.form.get("naziv")?.setValue(this.drzava?.naziv);
  
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
