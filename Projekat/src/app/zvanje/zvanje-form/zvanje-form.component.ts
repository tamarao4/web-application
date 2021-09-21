import { NaucnaOblast } from './../../model/naucna-oblast';
import { Nastavnik } from './../../model/nastavnik';
import { TipZvanja } from 'src/app/model/tip-zvanja';
import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { Zvanje } from 'src/app/model/zvanje';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ZvanjeService } from 'src/app/services/zvanje.service';

@Component({
  selector: 'app-zvanje-form',
  templateUrl: './zvanje-form.component.html',
  styleUrls: ['./zvanje-form.component.css']
})
export class ZvanjeFormComponent implements OnInit {
  // @Input()
  // tipZvanjaId: Nastavnik [] = []

  @Input()
  tipZvanja: TipZvanja [] = []
  @Input()
  nastavnik: Nastavnik [] = []
  @Input()
  naucnaOblast: NaucnaOblast [] = []
  @Input()
  zvanje: Zvanje|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    datumIzbora: new FormControl(null, [Validators.required]),
    datumPrestanka: new FormControl(null, [Validators.required]),
    tipZvanja: new FormControl(null, [Validators.required]),
    nastavik: new FormControl(null),
    naucnaOblast: new FormControl(null),
  });

  constructor(private zvanjeService: ZvanjeService, private router: Router) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.zvanje?.id);
    this.form.get("datumIzbora")?.setValue(this.zvanje?.datumIzbora);
    this.form.get("datumPrestanka")?.setValue(this.zvanje?.datumPrestanka);
    this.form.get("tipZvanja")?.setValue({...this.zvanje?.tipZvanja});
    this.form.get("nastavnik")?.setValue({...this.zvanje?.nastavnik});
    this.form.get("naucnaOblast")?.setValue({...this.zvanje?.naucnaOblast});
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
