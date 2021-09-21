import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NaucniRadFormComponent } from './naucni-rad-form.component';

describe('NaucniRadFormComponent', () => {
  let component: NaucniRadFormComponent;
  let fixture: ComponentFixture<NaucniRadFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NaucniRadFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NaucniRadFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
