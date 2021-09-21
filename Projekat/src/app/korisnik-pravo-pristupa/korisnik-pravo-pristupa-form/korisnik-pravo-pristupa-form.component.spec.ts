import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KorisnikPravoPristupaFormComponent } from './korisnik-pravo-pristupa-form.component';

describe('KorisnikPravoPristupaFormComponent', () => {
  let component: KorisnikPravoPristupaFormComponent;
  let fixture: ComponentFixture<KorisnikPravoPristupaFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KorisnikPravoPristupaFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KorisnikPravoPristupaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
