import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NeregistrovaniKorisnikFormComponent } from './neregistrovani-korisnik-form.component';

describe('NeregistrovaniKorisnikFormComponent', () => {
  let component: NeregistrovaniKorisnikFormComponent;
  let fixture: ComponentFixture<NeregistrovaniKorisnikFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NeregistrovaniKorisnikFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NeregistrovaniKorisnikFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
