import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApstraktFormComponent } from './apstrakt-form.component';

describe('ApstraktFormComponent', () => {
  let component: ApstraktFormComponent;
  let fixture: ComponentFixture<ApstraktFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApstraktFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ApstraktFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
