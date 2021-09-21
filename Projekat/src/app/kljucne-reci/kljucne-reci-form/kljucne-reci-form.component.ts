import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { KljucneReci } from 'src/app/model/kljucne-reci';

@Component({
  selector: 'app-kljucne-reci-form',
  templateUrl: './kljucne-reci-form.component.html',
  styleUrls: ['./kljucne-reci-form.component.css']
})
export class KljucneReciFormComponent implements OnInit {

  @Input()
  kljucnereci: KljucneReci|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    reci: new FormControl(null, [Validators.required])
  });

  constructor(private router: Router) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.kljucnereci?.id);
    this.form.get("reci")?.setValue(this.kljucnereci?.reci);
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
