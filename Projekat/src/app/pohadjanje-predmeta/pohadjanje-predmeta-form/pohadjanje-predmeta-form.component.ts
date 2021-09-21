import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PohadjanjePredmeta } from 'src/app/model/pohadjanje-predmeta';
import { PohadjanjePredmetaService } from 'src/app/services/pohadjanje-predmeta.service';

@Component({
  selector: 'app-pohadjanje-predmeta-form',
  templateUrl: './pohadjanje-predmeta-form.component.html',
  styleUrls: ['./pohadjanje-predmeta-form.component.css']
})
export class PohadjanjePredmetaFormComponent implements OnInit {
  @Input()
  pohadjanjePredmeta: PohadjanjePredmeta|null = null

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    konacnaOcena: new FormControl(null, [Validators.required]),
    
  });

  constructor(private pohadjanjePredmetaService: PohadjanjePredmetaService, private router: Router) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.pohadjanjePredmeta?.id);
    this.form.get("konacnaOcena")?.setValue(this.pohadjanjePredmeta?.konacnaOcena);
    
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
