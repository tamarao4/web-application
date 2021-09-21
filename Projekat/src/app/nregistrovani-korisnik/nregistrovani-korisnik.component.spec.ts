import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NregistrovaniKorisnikComponent } from './nregistrovani-korisnik.component';

describe('NregistrovaniKorisnikComponent', () => {
  let component: NregistrovaniKorisnikComponent;
  let fixture: ComponentFixture<NregistrovaniKorisnikComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NregistrovaniKorisnikComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NregistrovaniKorisnikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
