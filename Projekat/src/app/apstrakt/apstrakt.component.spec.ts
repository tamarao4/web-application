import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApstraktComponent } from './apstrakt.component';

describe('ApstraktComponent', () => {
  let component: ApstraktComponent;
  let fixture: ComponentFixture<ApstraktComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApstraktComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ApstraktComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
