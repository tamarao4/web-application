import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ObjavljeniNaucniRadFormComponent } from './objavljeni-naucni-rad-form.component';

describe('ObjavljeniNaucniRadFormComponent', () => {
  let component: ObjavljeniNaucniRadFormComponent;
  let fixture: ComponentFixture<ObjavljeniNaucniRadFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ObjavljeniNaucniRadFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ObjavljeniNaucniRadFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
