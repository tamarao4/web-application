import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DrzavaFormaComponent } from './drzava-forma.component';

describe('DrzavaFormaComponent', () => {
  let component: DrzavaFormaComponent;
  let fixture: ComponentFixture<DrzavaFormaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DrzavaFormaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DrzavaFormaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
