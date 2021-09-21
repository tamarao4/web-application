import { NeregistrovaniKorisnik } from './../../model/neregistrovani-korisnik';
import { NaucniRad } from './../../model/naucni-rad';
import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { Autor } from 'src/app/model/autor';
import { Nastavnik } from 'src/app/model/nastavnik';
import { NaucnaOblast } from 'src/app/model/naucna-oblast';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AutoriService } from 'src/app/services/autori.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-autori-form',
  templateUrl: './autori-form.component.html',
  styleUrls: ['./autori-form.component.css']
})
export class AutoriFormComponent implements OnInit {
  @Input()
  neregistrovaniKorisnik:NeregistrovaniKorisnik [] = []
  @Input()
  naucniRad: NaucniRad [] = []
  @Input()
  nastavnik: Nastavnik [] = []
  @Input()
  student: NaucnaOblast [] = []
  @Input()
  autor: Autor|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    naucniRad: new FormControl(null),
    neregistrovaniKorisnik: new FormControl(null),
    nastavnik: new FormControl(null),
    student: new FormControl(null),
  });

  constructor(private autorService: AutoriService, private router: Router) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.autor?.id);
    this.form.get("naucniRad")?.setValue(this.autor?.naucniRad);
    this.form.get("neregistrovaniKorisnik")?.setValue(this.autor?.neregistrovaniKorisnik);
    this.form.get("nastavnik")?.setValue({...this.autor?.nastavnik});
    this.form.get("nastavnikId")?.setValue({...this.autor?.nastavnik});
    this.form.get("student")?.setValue({...this.autor?.student});
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
