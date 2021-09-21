import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KljucneReciComponent } from './kljucne-reci.component';

describe('KljucneReciComponent', () => {
  let component: KljucneReciComponent;
  let fixture: ComponentFixture<KljucneReciComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KljucneReciComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KljucneReciComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
