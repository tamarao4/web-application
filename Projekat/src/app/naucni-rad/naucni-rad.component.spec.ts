import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NaucniRadComponent } from './naucni-rad.component';

describe('NaucniRadComponent', () => {
  let component: NaucniRadComponent;
  let fixture: ComponentFixture<NaucniRadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NaucniRadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NaucniRadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
