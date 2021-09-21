import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KljucneReciFormComponent } from './kljucne-reci-form.component';

describe('KljucneReciFormComponent', () => {
  let component: KljucneReciFormComponent;
  let fixture: ComponentFixture<KljucneReciFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KljucneReciFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KljucneReciFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
