import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoriFormComponent } from './autori-form.component';

describe('AutoriFormComponent', () => {
  let component: AutoriFormComponent;
  let fixture: ComponentFixture<AutoriFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AutoriFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AutoriFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
