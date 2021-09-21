import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ObjavljeniNaucniRadComponent } from './objavljeni-naucni-rad.component';

describe('ObjavljeniNaucniRadComponent', () => {
  let component: ObjavljeniNaucniRadComponent;
  let fixture: ComponentFixture<ObjavljeniNaucniRadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ObjavljeniNaucniRadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ObjavljeniNaucniRadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
