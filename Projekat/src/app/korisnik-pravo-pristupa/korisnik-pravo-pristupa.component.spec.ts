import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KorisnikPravoPristupaComponent } from './korisnik-pravo-pristupa.component';

describe('KorisnikPravoPristupaComponent', () => {
  let component: KorisnikPravoPristupaComponent;
  let fixture: ComponentFixture<KorisnikPravoPristupaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KorisnikPravoPristupaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KorisnikPravoPristupaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
