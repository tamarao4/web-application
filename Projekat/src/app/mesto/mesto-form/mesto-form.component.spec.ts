import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MestoFormComponent } from './mesto-form.component';

describe('MestoFormComponent', () => {
  let component: MestoFormComponent;
  let fixture: ComponentFixture<MestoFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MestoFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MestoFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
